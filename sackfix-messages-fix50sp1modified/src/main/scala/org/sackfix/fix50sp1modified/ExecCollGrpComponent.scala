package org.sackfix.fix50sp1modified

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixComponent, SfFixDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180821
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP1.modified.xml
  */
case class ExecCollGrpComponent(noExecsField:Option[NoExecsField]=None,
                                execsGroups: Option[List[ExecsGroup]]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noExecsField.map(_.value).getOrElse(0) != execsGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoExecsField.TagId,noExecsField.map(_.value).getOrElse(0), execsGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    noExecsField.foreach(fmt(b,_))
    execsGroups.getOrElse(List.empty).foreach(fmt(b,_))
    b
  }

}
     
object ExecCollGrpComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    ExecsGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    NoExecsField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    ExecsGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    ExecsGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoExecsField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = ExecsGroup.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[ExecCollGrpComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(ExecCollGrpComponent(myFields.get(NoExecsField.TagId).flatMap(f=>NoExecsField.decode(f)),
        if (nextTagPosLookup.contains(NoExecsField.TagId)) ExecsGroup.decode(flds, nextTagPosLookup(NoExecsField.TagId)) else None))
    } else None
  }

    
}
     