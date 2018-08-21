package org.sackfix.fix50sp2

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixComponent, SfFixDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180821
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP2.xml
  */
case class MatchRulesComponent(noMatchRulesField:Option[NoMatchRulesField]=None,
                               matchRulesGroups: Option[List[MatchRulesGroup]]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noMatchRulesField.map(_.value).getOrElse(0) != matchRulesGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoMatchRulesField.TagId,noMatchRulesField.map(_.value).getOrElse(0), matchRulesGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    noMatchRulesField.foreach(fmt(b,_))
    matchRulesGroups.getOrElse(List.empty).foreach(fmt(b,_))
    b
  }

}
     
object MatchRulesComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    MatchRulesGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    NoMatchRulesField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    MatchRulesGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    MatchRulesGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoMatchRulesField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = MatchRulesGroup.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[MatchRulesComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(MatchRulesComponent(myFields.get(NoMatchRulesField.TagId).flatMap(f=>NoMatchRulesField.decode(f)),
        if (nextTagPosLookup.contains(NoMatchRulesField.TagId)) MatchRulesGroup.decode(flds, nextTagPosLookup(NoMatchRulesField.TagId)) else None))
    } else None
  }

    
}
     