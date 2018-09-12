package org.sackfix.fix50sp2modified

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixComponent, SfFixDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180902
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP2.modified.xml
  */
case class StrmAsgnReqGrpComponent(noAsgnReqsField:Option[NoAsgnReqsField]=None,
                                   asgnReqsGroups: Option[List[AsgnReqsGroup]]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noAsgnReqsField.map(_.value).getOrElse(0) != asgnReqsGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoAsgnReqsField.TagId,noAsgnReqsField.map(_.value).getOrElse(0), asgnReqsGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    noAsgnReqsField.foreach(fmt(b,_))
    asgnReqsGroups.getOrElse(List.empty).foreach(fmt(b,_))
    b
  }

}
     
object StrmAsgnReqGrpComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    AsgnReqsGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    NoAsgnReqsField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    AsgnReqsGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    AsgnReqsGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoAsgnReqsField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = AsgnReqsGroup.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[StrmAsgnReqGrpComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(StrmAsgnReqGrpComponent(myFields.get(NoAsgnReqsField.TagId).flatMap(f=>NoAsgnReqsField.decode(f)),
        if (nextTagPosLookup.contains(NoAsgnReqsField.TagId)) AsgnReqsGroup.decode(flds, nextTagPosLookup(NoAsgnReqsField.TagId)) else None))
    } else None
  }

    
}
     