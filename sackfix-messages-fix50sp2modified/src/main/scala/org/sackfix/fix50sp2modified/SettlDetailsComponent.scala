package org.sackfix.fix50sp2modified

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixComponent, SfFixDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180821
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP2.modified.xml
  */
case class SettlDetailsComponent(noSettlDetailsField:Option[NoSettlDetailsField]=None,
                                 settlDetailsGroups: Option[List[SettlDetailsGroup]]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noSettlDetailsField.map(_.value).getOrElse(0) != settlDetailsGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoSettlDetailsField.TagId,noSettlDetailsField.map(_.value).getOrElse(0), settlDetailsGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    noSettlDetailsField.foreach(fmt(b,_))
    settlDetailsGroups.getOrElse(List.empty).foreach(fmt(b,_))
    b
  }

}
     
object SettlDetailsComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    SettlDetailsGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    NoSettlDetailsField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    SettlDetailsGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    SettlDetailsGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoSettlDetailsField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = SettlDetailsGroup.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SettlDetailsComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(SettlDetailsComponent(myFields.get(NoSettlDetailsField.TagId).flatMap(f=>NoSettlDetailsField.decode(f)),
        if (nextTagPosLookup.contains(NoSettlDetailsField.TagId)) SettlDetailsGroup.decode(flds, nextTagPosLookup(NoSettlDetailsField.TagId)) else None))
    } else None
  }

    
}
     