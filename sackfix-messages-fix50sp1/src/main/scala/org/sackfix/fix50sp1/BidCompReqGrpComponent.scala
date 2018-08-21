package org.sackfix.fix50sp1

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixComponent, SfFixDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180821
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP1.xml
  */
case class BidCompReqGrpComponent(noBidComponentsField:Option[NoBidComponentsField]=None,
                                  bidComponentsGroups: Option[List[BidComponentsGroup]]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noBidComponentsField.map(_.value).getOrElse(0) != bidComponentsGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoBidComponentsField.TagId,noBidComponentsField.map(_.value).getOrElse(0), bidComponentsGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    noBidComponentsField.foreach(fmt(b,_))
    bidComponentsGroups.getOrElse(List.empty).foreach(fmt(b,_))
    b
  }

}
     
object BidCompReqGrpComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    BidComponentsGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    NoBidComponentsField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    BidComponentsGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    BidComponentsGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoBidComponentsField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = BidComponentsGroup.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[BidCompReqGrpComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(BidCompReqGrpComponent(myFields.get(NoBidComponentsField.TagId).flatMap(f=>NoBidComponentsField.decode(f)),
        if (nextTagPosLookup.contains(NoBidComponentsField.TagId)) BidComponentsGroup.decode(flds, nextTagPosLookup(NoBidComponentsField.TagId)) else None))
    } else None
  }

    
}
     