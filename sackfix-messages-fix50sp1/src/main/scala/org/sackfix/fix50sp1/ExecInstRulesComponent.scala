package org.sackfix.fix50sp1

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixComponent, SfFixDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180902
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP1.xml
  */
case class ExecInstRulesComponent(noExecInstRulesField:Option[NoExecInstRulesField]=None,
                                  execInstRulesGroups: Option[List[ExecInstRulesGroup]]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noExecInstRulesField.map(_.value).getOrElse(0) != execInstRulesGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoExecInstRulesField.TagId,noExecInstRulesField.map(_.value).getOrElse(0), execInstRulesGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    noExecInstRulesField.foreach(fmt(b,_))
    execInstRulesGroups.getOrElse(List.empty).foreach(fmt(b,_))
    b
  }

}
     
object ExecInstRulesComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    ExecInstRulesGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    NoExecInstRulesField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    ExecInstRulesGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    ExecInstRulesGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoExecInstRulesField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = ExecInstRulesGroup.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[ExecInstRulesComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(ExecInstRulesComponent(myFields.get(NoExecInstRulesField.TagId).flatMap(f=>NoExecInstRulesField.decode(f)),
        if (nextTagPosLookup.contains(NoExecInstRulesField.TagId)) ExecInstRulesGroup.decode(flds, nextTagPosLookup(NoExecInstRulesField.TagId)) else None))
    } else None
  }

    
}
     